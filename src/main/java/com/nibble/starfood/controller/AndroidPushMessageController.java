package com.nibble.starfood.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.nibble.starfood.ServiceI.CustDetServiceI;
import com.nibble.starfood.hibernatemodel.AndroidPushMsg;
import com.nibble.starfood.webservices.model.Content;

/**
 * @author J
 *
 */
@Controller
public class AndroidPushMessageController {

    @Autowired
    CustDetServiceI cust;

    /**
     * @param request
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "android", method = RequestMethod.GET)
    public void android(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // put
        final String postUrl = "https://android.googleapis.com/gcm/send";
        // in
        // your
        // url
        final HttpClient httpClient = new DefaultHttpClient();
        final String GOOGLE_SERVER_KEY = "AIzaSyAKDFA36WAa2GBj_GHfDaWm5u5UyR7GTtc";
        final Gson gson = new Gson();
        final HttpPost post = new HttpPost(postUrl);
        final JsonObject jsonObj = new JsonObject();
        final JSONArray array = new JSONArray();
        jsonObj.addProperty("title", "title");
        jsonObj.addProperty("message", "Test message");
        jsonObj.addProperty("subtitle", "subtitle");
        jsonObj.addProperty("tickerText", "tickerText");
        jsonObj.addProperty("vibrate", 1);
        jsonObj.addProperty("sound", 1);
        array.add(jsonObj);
        final HashMap<String, Object> map = new HashMap<String, Object>();
        final HashMap<String, Object> data = new HashMap<String, Object>();
        map.put("title", "title");
        map.put("message", "Test message");
        // map.put("subtitle", "subtitle");
        // map.put("tickerText", "tickerText");
        // map.put("vibrate", 1);
        // map.put("sound", 1);
        data.put("data", map);
        data.put("registration_ids", "sdcsfsdf");
        // regId.addProperty("registration_ids", "");
        // convert
//        final StringEntity postingString = new StringEntity(gson.toJson(data));//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
        // your
        // pojo
        // to
        // json
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");
        post.setHeader("Authorization", "key=" + GOOGLE_SERVER_KEY);
        final HttpResponse response = httpClient.execute(post);
        System.out.println(response);
        final PrintWriter out = resp.getWriter();
        out.println(postingString);
    // return "GCMNotification";
    // return postingString;
    }

    @RequestMapping(value = "android2", method = RequestMethod.POST)
    public void android2(HttpServletResponse resp, HttpServletRequest request) {
        try {
            final List<AndroidPushMsg> regIdList = cust.getAndroidPushMsgRegIdList();
            final Iterator<AndroidPushMsg> regIdIt = regIdList.iterator();
            // 1. URL
            final URL url = new URL("https://android.googleapis.com/gcm/send");
            final String message = request.getParameter("message");
            // 2. Open connection
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            StringBuffer response = null;
            // 3. Specify POST method
            conn.setRequestMethod("POST");
            final String GOOGLE_SERVER_KEY = "AIzaSyAKDFA36WAa2GBj_GHfDaWm5u5UyR7GTtc";
            // 4. Set the headers
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "key=" + GOOGLE_SERVER_KEY);
            conn.setDoOutput(true);
            // 5. Add JSON data into POST request body
            // `5.1 Use Jackson object mapper to convert Contnet object into
            // JSON
            final ObjectMapper mapper = new ObjectMapper();
            final Content content = new Content();
            content.createData("title", message);
            while (regIdIt.hasNext()) {
                final AndroidPushMsg and = regIdIt.next();
                content.addRegId(and.getRegId());
            }
            // 5.2 Get connection output stream
            // String regId=and.getRegId();
            // String
//            // regId="APA91bEkrLwkKOluOQiWEXn4g5eImNweVeu3oxCk6JTzi4lZM6FLzRzrpjCszn-8Gy9g0h9YXDG45R0SS3G9Aij0XkfklP172wgSaV86aOLWS82a2j9-xYWEXTM2-fx9UxQMvRkOL8-pW6oUfRqkeMz5zyU6KrlPLg";//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
            final DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            // 5.3 Copy Content "JSON" into
            mapper.writeValue(wr, content);
            // 5.4 Send the request
            wr.flush();
            // 5.5 close
            wr.close();
            final BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // 7. Print result
            System.out.println(response.toString());
            final PrintWriter out = resp.getWriter();
            out.println(response);
        } catch (final MalformedURLException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "GCMNotificationPost", method = RequestMethod.POST)
    public void GCMNotificationPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String GOOGLE_SERVER_KEY = "AIzaSyC3iFOG_zRzsUA9CuOhoUxJ7RxBs8gYEEM";
        final String REGISTER_NAME = "name";
        final String MESSAGE_KEY = "message";
        final String TO_NAME = "toName";
        final String action = request.getParameter("action");
        if ("shareRegId".equalsIgnoreCase(action)) {
            final String name = request.getParameter("name");
            final String reg = request.getParameter("regId");
            final AndroidPushMsg msg = new AndroidPushMsg();
            msg.setName(name);
            msg.setRegId(reg);
            cust.saveAndroidPushMsg(msg);
            request.setAttribute("pushStatus", "GCM Name and corresponding RegId Received.");
            request.getRequestDispatcher("/WEB-INF/views/GCMNotification.jsp").forward(request, response);
        } else if ("sendMessage".equalsIgnoreCase(action)) {
            try {
                final String fromName = request.getParameter(REGISTER_NAME);
                final String toName = request.getParameter(TO_NAME);
                final String userMessage = request.getParameter(MESSAGE_KEY);
                final Sender sender = new Sender(GOOGLE_SERVER_KEY);
                final Message message = new Message.Builder().timeToLive(30).delayWhileIdle(true).addData(MESSAGE_KEY, userMessage).addData(REGISTER_NAME, fromName).build();
                final AndroidPushMsg msg = cust.getAndroidPushMsgByEmail(toName);
                final String regId = msg.getRegId();
                final Result result = sender.send(message, regId, 1);
                request.setAttribute("pushStatus", result.toString());
                request.setAttribute("userName", toName);
                request.setAttribute("regId", regId);
            } catch (final IOException ioe) {
                ioe.printStackTrace();
                request.setAttribute("pushStatus", "RegId required: " + ioe.toString());
            } catch (final Exception e) {
                e.printStackTrace();
                request.setAttribute("pushStatus", e.toString());
            }
            request.getRequestDispatcher("/WEB-INF/views/GCMNotification.jsp").forward(request, response);
        } else if ("multicast".equalsIgnoreCase(action)) {
            try {
                final String fromName = request.getParameter(REGISTER_NAME);
                final String userMessage = request.getParameter(MESSAGE_KEY);
                final Sender sender = new Sender(GOOGLE_SERVER_KEY);
                final Message message = new Message.Builder().timeToLive(30).delayWhileIdle(true).addData(MESSAGE_KEY, userMessage).addData(REGISTER_NAME, fromName).build();
                final Map<?, String> regIdMap = null;
                @SuppressWarnings("null") final List<String> regIdList = new ArrayList<String>(regIdMap.values());
                final MulticastResult multiResult = sender.send(message, regIdList, 1);
                request.setAttribute("pushStatus", multiResult.toString());
            } catch (final IOException ioe) {
                ioe.printStackTrace();
                request.setAttribute("pushStatus", "RegId required: " + ioe.toString());
            } catch (final Exception e) {
                e.printStackTrace();
                request.setAttribute("pushStatus", e.toString());
            }
            request.getRequestDispatcher("/WEB-INF/views/GCMNotification.jsp").forward(request, response);
        }
    }

    /**
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "GCMNotification", method = RequestMethod.GET)
    public String GCMNotificationPostGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "GCMNotification";
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "GCMRegister", method = RequestMethod.POST)
    public void GCMNotificationRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String name = request.getParameter("name");
        final String reg = request.getParameter("regId");
        final String email = request.getParameter("email");
        final AndroidPushMsg msg = new AndroidPushMsg();
        msg.setName(name);
        msg.setRegId(reg);
        msg.setEmail(email);
        cust.saveAndroidPushMsg(msg);
        final PrintWriter out = response.getWriter();
        out.println("TRUE");
    // return "GCMNotification";
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "deleteRegId", method = RequestMethod.POST)
    public void regIdDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String reg = request.getParameter("regId");
        cust.removeAndroidPushMsg(reg);
        final PrintWriter out = response.getWriter();
        out.println("TRUE");
    }
}

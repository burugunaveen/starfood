package com.nibble.starfood.webservices.model;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Content implements Serializable {

    /**
   * 
   */

    private static final long serialVersionUID = 1L;
    public List<String> registration_ids;
    public Map<String, Object> data;

    public void addRegId(String regId) {
	if (registration_ids == null)
	    registration_ids = new LinkedList<String>();
	registration_ids.add(regId);
    }

    public void createData(String title, String message) {
	if (data == null)
	    data = new HashMap<String, Object>();

	data.put("title", title);
	data.put("message", message);
	data.put("subtitle", "subtitle");
	data.put("tickerText", "tickerText");
	data.put("vibrate", 1);
	data.put("sound", 1);
	data.put("customData", message);
	data.put("price", message);
    }

}
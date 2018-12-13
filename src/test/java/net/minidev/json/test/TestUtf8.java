package net.minidev.json.test;

import java.io.ByteArrayInputStream;
import java.io.StringReader;

import junit.framework.TestCase;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

public class TestUtf8 extends TestCase {
	// Sinhalese language
	static String[] nonLatinTexts = new String[] { "à·à·à¶à·à¶½ à¶¢à·à¶­à·à¶º", "æ¥æ¬èª", "Ð ÑÑÑÐºÐ¸Ð¹", "ÙØ§Ø±Ø³Û", "íêµ­ì´", "ÕÕ¡ÕµÕ¥ÖÕ¥Õ¶", "à¤¹à¤¿à¤¨à¥à¤¦à¥", "×¢××¨××ª", "ä¸­æ", "á áá­á", "à´®à´²à´¯à´¾à´³à´",
			"ÜÜ¬ÜÜªÜÜ", "ááá áááá£á á" };

	public void testString() throws Exception {
		for (String nonLatinText : nonLatinTexts) {
			String s = "{\"key\":\"" + nonLatinText + "\"}";
			JSONObject obj = (JSONObject) JSONValue.parse(s);
			String v = (String) obj.get("key"); // result is incorrect
			System.out.println(v);
			assertEquals(v, nonLatinText);
		}
	}

	public void testReader() throws Exception {
		for (String nonLatinText : nonLatinTexts) {
			String s = "{\"key\":\"" + nonLatinText + "\"}";
			StringReader reader = new StringReader(s);
			JSONObject obj = (JSONObject) JSONValue.parse(reader);

			String v = (String) obj.get("key"); // result is incorrect
			System.out.println(v);
			assertEquals(v, nonLatinText);
		}
	}

	public void testInputStream() throws Exception {
		for (String nonLatinText : nonLatinTexts) {
			String s = "{\"key\":\"" + nonLatinText + "\"}";
			ByteArrayInputStream bis = new ByteArrayInputStream(s.getBytes("utf8"));
			JSONObject obj = (JSONObject) JSONValue.parse(bis);
			String v = (String) obj.get("key"); // result is incorrect
			System.out.println(v);
			assertEquals(v, nonLatinText);
		}
	}

	public void testBytes() throws Exception {
		for (String nonLatinText : nonLatinTexts) {
			String s = "{\"key\":\"" + nonLatinText + "\"}";
			byte[] bs = s.getBytes("utf8");
			JSONObject obj = (JSONObject) JSONValue.parse(bs);
			String v = (String) obj.get("key"); // result is incorrect
			System.out.println(v);
			assertEquals(v, nonLatinText);
		}
	}
}

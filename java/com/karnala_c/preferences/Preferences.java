/*
 * Created: 12.09.2018 09:00 UTC +7	Ryan Asianto, Jakarta Jak-Sel 12270 Indonesia
 * Class: Preferences
 * Language: Java
 *
 * Intended to read/write shared preferenced data
 */

package com.karnala_c.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

public class Preferences
{
	private int mode = MODE_PRIVATE;
	
	private String pref_name;
	
	private SharedPreferences shared_pref;
	
	private SharedPreferences.Editor shared_editor;
	
	private Context context;
	
	/**
	 * Constructor
	 */
	public Preferences(Context context, String preference_name)
	{
		this.context = context;
		
		pref_name = preference_name;
		
		shared_pref = context.getSharedPreferences(preference_name, mode);
		
		shared_editor = shared_pref.edit();
	}
	
	// Function
	
	/**
	 * Read Data Preferences
	 * @param name Data Name
	 */
	public boolean readBoolean(String name)
	{
		return shared_pref.getBoolean(name, false);
	}
	
	/**
	 * Read Data Preferences
	 * @param name Data Name
	 */
	public float readFloat(String name)
	{
		return shared_pref.getFloat(name, 0);
	}
	
	/**
	 * Read Data Preferences
	 * @param name Data Name
	 */
	public int readInt(String name)
	{
		return shared_pref.getInt(name, 0);
	}
	
	/**
	 * Read Data Preferences
	 * @param name Data Name
	 */
	public long readLong(String name)
	{
		return shared_pref.getLong(name, 0);
	}
	
	/**
	 * Read Data Preferences
	 * @param name Data Name
	 */
	public String readString(String name)
	{
		return shared_pref.getString(name, "");
	}
	
	/**
	 * Read Data Preferences
	 * @param name Data Name
	 */
	public Set<String> read (String name)
	{
		return shared_pref.getStringSet(name, null);
	}
	
	// void

	/**
	 * Write Data Preferences
	 * @param name Data Name
	 * @param value Data Value
	 */
	public void write(String name, boolean value)
	{
		shared_editor.putBoolean(name, value);
		
		writeCommit();
	}
	
	/**
	 * Write Data Preferences
	 * @param name Data Name
	 * @param value Data Value
	 */
	public void write(String name, float value)
	{
		shared_editor.putFloat(name, value);
		
		writeCommit();
	}
	
	/**
	 * Write Data Preferences
	 * @param name Data Name
	 * @param value Data Value
	 */
	public void write(String name, int value)
	{
		shared_editor.putInt(name, value);
		
		writeCommit();
	}
	
	/**
	 * Write Data Preferences
	 * @param name Data Name
	 * @param value Data Value
	 */
	public void write(String name, long value)
	{
		shared_editor.putLong(name, value);
		
		writeCommit();
	}
	
	/**
	 * Write Data Preferences
	 * @param name Data Name
	 * @param value Data Value
	 */
	public void write(String name, String value)
	{
		shared_editor.putString(name, value);
		
		writeCommit();
	}
	
	/**
	 * Write Data Preferences
	 * @param name Data Name
	 * @param value Data Value
	 */
	public void write(String name, Set<String> value)
	{
		shared_editor.putStringSet(name, value);
		
		writeCommit();
	}
	
	/**
	 * Write Data Preferences
	 * @param name Data Name
	 * @param value Data Value
	 */
	public void write(String name, Object value)
	{
		String var_type = value.getClass().getSimpleName().toLowerCase();
		
		switch(var_type)
		{
			case "boolean":
				boolean val_bool = Boolean.parseBoolean(value.toString());
				
				write(name, val_bool);
				
				break;
			
			case "collections":
			case "hashmap":
			case "hashset":
			case "map":
			case "set":
				Set<String> val_set = (Set<String>)value;
				
				write(name, val_set);
			
			case "float":
				float val_float = Float.parseFloat(value.toString());
				
				write(name, val_float);
				
				break;
			
			case "int":
			case "integer":
				int val_int = Integer.parseInt(value.toString());
				
				write(name, val_int);
				
				break;
			
			case "long":
				long val_long = Long.parseLong(value.toString());
				
				write(name, val_long);
				
				break;
			
			default:
				write(name, value.toString());
				
				break;
		}
	}
	
	/**
	 * Commit Write Preferences
	 */
	private void writeCommit()
	{
		shared_editor.commit();
	}
}

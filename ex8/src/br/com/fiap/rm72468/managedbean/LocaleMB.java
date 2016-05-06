package br.com.fiap.rm72468.managedbean;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

public class LocaleMB {

	   private String locale;

	   private static java.util.Map<String,Object> countries;

	   static{
		  countries = new LinkedHashMap<String,Object>();
	      countries.put("Portugues", Locale.forLanguageTag("pt"));
	      countries.put("English", Locale.ENGLISH);
	      countries.put("Espanol", Locale.forLanguageTag("es"));
	      //countries.put("French", Locale.FRENCH);
	   }

	   public Map<String, Object> getCountries() {
	      return countries;
	   }

	   public String getLocale() {
			if(locale==null){
				locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale().toString();
			}
	      return locale;
	   }

	   public void setLocale(String locale) {
	      this.locale = locale;
	   }

	   //value change event listener
	   public void localeChanged(ValueChangeEvent e){
	      String newLocaleValue = e.getNewValue().toString();
	      for (Entry<String, Object> entry : countries.entrySet()) {
	         if(entry.getValue().toString().equals(newLocaleValue)){
	            FacesContext.getCurrentInstance()
	               .getViewRoot().setLocale((Locale)entry.getValue());         
	         }
	      }
	   }
}
package se.adopi.edu.konditori.entities.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import se.adopi.edu.konditori.backing.BakeryBean;
import se.adopi.edu.konditori.entities.Pastry;

@FacesConverter(forClass=Pastry.class)
public class PastryConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		int id;
		try {
			id = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return "";
		}
		BakeryBean bb = context.getApplication().evaluateExpressionGet(context, "#{bakeryBean}", BakeryBean.class);
		return bb.getPastryEJB().find(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) return "";
		if (!(value instanceof Pastry)) return "";
		
		return Integer.toString( ((Pastry) value).getPastryId() );
	}
	
}
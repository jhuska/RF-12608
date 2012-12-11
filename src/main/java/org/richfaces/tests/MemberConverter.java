package org.richfaces.tests;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.jboss.solder.logging.Logger;

@RequestScoped
@FacesConverter("memberConverter")
public class MemberConverter implements Converter {
	@Inject private Logger log;
	
	@Inject private ClubEntityManager em;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String memberIdStr) {
		
		if (memberIdStr == null || memberIdStr.isEmpty()) return null;
		
		Long memberId = Long.parseLong(memberIdStr);
		
		MemberEntity m = em.getEm().find(MemberEntity.class, memberId);
		
		return m;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object member) {
		if (member == null) return "";
		
		if (member instanceof String) return (String) member;
		
		return ((MemberEntity) member).getMemberId().toString();
	}
}

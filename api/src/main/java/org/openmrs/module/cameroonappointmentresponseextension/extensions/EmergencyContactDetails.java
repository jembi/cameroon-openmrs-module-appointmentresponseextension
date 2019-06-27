package org.openmrs.module.cameroonappointmentresponseextension.extensions;

import java.util.HashMap;
import java.util.Map;

import org.openmrs.PersonAttributeType;
import org.openmrs.api.context.Context;
import org.openmrs.module.appointments.model.Appointment;
import org.openmrs.module.appointments.web.extension.AppointmentResponseExtension;
import org.springframework.stereotype.Component;

@Component
public class EmergencyContactDetails implements AppointmentResponseExtension {
	
	@Override
	public Map<String, String> run(Appointment appointment) {
		Map<String, String> additionalInfo = new HashMap<String, String>();
		additionalInfo.put("EMERGENCY_CONTACT_PHONE", getPersonAttribute(""));
		additionalInfo.put("EMERGENCY_CONTACT_NAME", getPersonAttribute(""));
		additionalInfo.put("EMERGENCY_CONTACT_RELATIONSHIP", getPersonAttribute(""));
		return additionalInfo;
	}
	
	public String getPersonAttribute(String personAttributeName) {
		PersonAttributeType personAttributeType = Context.getPersonService().getPersonAttributeTypeByName(
		    personAttributeName);
		if (personAttributeType != null) {
			return personAttributeType.getDescription();
		}
		return "";
	}
}

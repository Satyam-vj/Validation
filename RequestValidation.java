package org.jio.krishi.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jio.krishi.pojo.RequestResponsePojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RequestValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Value("${only.mobilenumber.validation}")
	private String onlyMobileNumberPattern;

	@Value("${only.number.validation}")
	private String onlyNumberPattern;

	@Value("${email.validation}")
	private String emailpattern;

	@Value("${only.char.with.lengthdept}")
	private String onlyLongCharValidation;

	@Value("${only.char.with.length}")
	private String namePattern;

	@Value("${only.char.with.space.in.between.length}")
	private String namewithSpacePattern;

	@Value("${special.char.validation}")
	private String specialCharValidation;

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

	}

	public void otpRequestValidation(RequestResponsePojo requestResponsePojo) throws ValidationFatalException {

		List<String> allErrors = new ArrayList<>();

		if (requestResponsePojo.getMobileNumber() != null && !requestResponsePojo.getMobileNumber().isEmpty()) {
			if (!String.format("%s", requestResponsePojo.getMobileNumber()).matches(onlyMobileNumberPattern)) {
				log.debug("Invalid Mobile Number");
				allErrors.add("Invalid Mobile Number");
			}
		} else {
			log.debug("Please provide  Mobile number");
			allErrors.add("Please provide  Mobile number");
		}
		if (requestResponsePojo.getAppId() == 0) {
			allErrors.add("Please provide Application Id");
		}
		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}

	}

	public void validateGetuserDetails(RequestResponsePojo requestResponsePojo) throws ValidationFatalException {
		List<String> allErrors = new ArrayList<>();

		if (requestResponsePojo.getMobileNumber() != null && !requestResponsePojo.getMobileNumber().isEmpty()) {
			if (!String.format("%s", requestResponsePojo.getMobileNumber()).matches(onlyMobileNumberPattern)) {
				allErrors.add("Invalid Mobile Number");
				allErrors.add("Invalid Mobile Number");
			}
		} else {
			allErrors.add("Please provide  Mobile number");
		}
		if (requestResponsePojo.getUserId() == 0) {
			allErrors.add("Please provide user Id");
		}
		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}

	}

	public void validateLoginByPassword(RequestResponsePojo requestResponsePojo) throws ValidationFatalException {
		List<String> allErrors = new ArrayList<>();

		if (requestResponsePojo.getMobileNumber() != null && !requestResponsePojo.getMobileNumber().isEmpty()) {
			if (!String.format("%s", requestResponsePojo.getMobileNumber()).matches(onlyMobileNumberPattern)) {
				allErrors.add("Invalid Mobile Number");
				allErrors.add("Invalid Mobile Number");
			}
		} else {
			allErrors.add("Please provide Mobile number");
		}
		if (requestResponsePojo.getPassword() == null) {
			allErrors.add("Please provide password");
		}
		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}
	}

	public void validateRegisterUser(RequestResponsePojo requestResponsePojo) throws ValidationFatalException {

		List<String> allErrors = new ArrayList<>();

		if (requestResponsePojo.getMobileNumber() != null && !requestResponsePojo.getMobileNumber().isEmpty()) {
			if (!String.format("%s", requestResponsePojo.getMobileNumber()).matches(onlyMobileNumberPattern)) {
				log.debug("Invalid Mobile Number");
				allErrors.add("Invalid Mobile Number");
			}
		} else {
			allErrors.add("Please provide  Mobile number");
		}
		if (requestResponsePojo.getRegistrationCategoryNo() == 0) {
			allErrors.add("Please provide  Registration category");
		}
		if (requestResponsePojo.getRegistrationType() == 0) {
			allErrors.add("Please provide  Registration type");
		}
		if (requestResponsePojo.getFirst_name() == null && requestResponsePojo.getFirst_name().isEmpty()) {
			allErrors.add("Please provide  First name");
		}
		if (requestResponsePojo.getLast_name() == null && requestResponsePojo.getLast_name().isEmpty()) {
			allErrors.add("Please provide  Last name");
		}
		if (requestResponsePojo.getEmailId().isEmpty() || requestResponsePojo.getEmailId() == null
				|| !requestResponsePojo.getEmailId().matches(emailpattern)) {
			allErrors.add("Invalid Email Id");
		}
		if (requestResponsePojo.getPan_no() != null && !requestResponsePojo.getPan_no().isEmpty()) {
			if (requestResponsePojo.getPan_no().length() != 10) {
				allErrors.add("Invalid Pan number");
			}
		} else {
			allErrors.add("Please provide Pan number");
		}
		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}

	}

	public void validateGetDistrictByState(RequestResponsePojo requestResponsePojo) throws ValidationFatalException {
		List<String> allErrors = new ArrayList<>();

		if (requestResponsePojo.getState() == 0) {
			allErrors.add("Please provide State Id");
		}
		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}

	}

	public void validateGetSubDistrictByDistrict(RequestResponsePojo requestResponsePojo)
			throws ValidationFatalException {
		List<String> allErrors = new ArrayList<>();

		if (requestResponsePojo.getDistrict() == 0) {
			allErrors.add("Please provide District Id");
		}
		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}

	}

	public void validateGetVillageBySubDistrict(RequestResponsePojo requestResponsePojo)
			throws ValidationFatalException {
		List<String> allErrors = new ArrayList<>();

		if (requestResponsePojo.getSubDistrict() == 0) {
			allErrors.add("Please provide SubDistrict Id");
		}
		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}

	}

	public void validateChangeByPassword(RequestResponsePojo requestResponsePojo) throws ValidationFatalException {

		List<String> allErrors = new ArrayList<>();

		if (requestResponsePojo.getUserId() == 0) {
			allErrors.add("Please provide user Id");
		}
		if (requestResponsePojo.getPassword() == null) {
			allErrors.add("Please provide password");
		}
		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}
	}

	public void saveTransportUser(RequestResponsePojo requestResponsePojo) throws ValidationFatalException {
		List<String> allErrors = new ArrayList<>();

		String charwithSpace = "^[a-zA-Z][a-zA-Z ]+[a-zA-Z]$";
		String charNumber = "^[a-zA-Z0-9]*$";
		Pattern charwithSpacePat = Pattern.compile(charwithSpace);
		Pattern charNumberPat = Pattern.compile(charNumber);
		Matcher companyName = charwithSpacePat.matcher(requestResponsePojo.getCompanyName());
		Matcher companyRegName = charNumberPat.matcher(requestResponsePojo.getCompanyRegNumber());
		Matcher gstnNo = charNumberPat.matcher(requestResponsePojo.getGstnNo());

		if (requestResponsePojo.getUserId() == 0) {
			allErrors.add("Please provide user Id");
		}

		if (requestResponsePojo.getTransporterType() != null && !requestResponsePojo.getTransporterType().isEmpty()) {
			if (requestResponsePojo.getTransporterType().equalsIgnoreCase("Own Company")) {
				if (requestResponsePojo.getCompanyName() != null && !requestResponsePojo.getCompanyName().isEmpty()) {
					if (!companyName.matches()) {
						allErrors.add("Invalid Company Name");
					}
				} else {
					allErrors.add("Please provide Company Name");
				}
				if (requestResponsePojo.getCompanyRegNumber() != null
						&& !requestResponsePojo.getCompanyRegNumber().isEmpty()) {
					if (!companyRegName.matches()) {
						allErrors.add("Invalid Company registration number");
					}
				} else {
					allErrors.add("Please provide Company registration number");
				}
				if (requestResponsePojo.getGstnNo() != null && !requestResponsePojo.getGstnNo().isEmpty()) {
					if (!gstnNo.matches()) {
						allErrors.add("Invalid Gstn number");
					}
				} else {
					allErrors.add("Please provide Gstn number");
				}
			}

		} else {
			allErrors.add("Please provide Transporter Type");
		}

		if (requestResponsePojo.getAadharNumber() == 0) {
			allErrors.add("Please provide Aadhar Number");
		}
		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}
	}

	public void saveVehicleData(RequestResponsePojo requestResponsePojo) throws ValidationFatalException {
		List<String> allErrors = new ArrayList<>();

		String VEHICLE_NUMBER_PATTERN = "^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$";
		Pattern pat = Pattern.compile(VEHICLE_NUMBER_PATTERN);

		Matcher matcher = pat.matcher(requestResponsePojo.getVehicleNumber());

		if (requestResponsePojo.getTransporterId() == 0) {
			allErrors.add("Please provide Transporter Id");
		}
		if (requestResponsePojo.getVehicleNumber() != null && !requestResponsePojo.getVehicleNumber().isEmpty()) {
			if (!matcher.matches()) {
				allErrors.add("Invalid Vehicle Number");
			}
		} else {
			allErrors.add("Please provide Vehicle Number");
		}
		if (requestResponsePojo.getVehicleType() == null && requestResponsePojo.getVehicleType().isEmpty()) {
			allErrors.add("Please provide valid Vechile Type");
		}
		
		if (requestResponsePojo.getVehicleFare() == 0) {
			allErrors.add("Please provide sVehicle Fare");
		}
		
		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}
	}

	public void saveDriverData(RequestResponsePojo requestResponsePojo) throws ValidationFatalException {
		List<String> allErrors = new ArrayList<>();

		if (requestResponsePojo.getDriverMobileNumber() != null
				&& !requestResponsePojo.getDriverMobileNumber().isEmpty()) {
			if (!String.format("%s", requestResponsePojo.getDriverMobileNumber()).matches(onlyMobileNumberPattern)) {
				allErrors.add("Invalid driver's Mobile Number");
			}
		} else {
			allErrors.add("Please provide driver's Mobile number");
		}

		if (requestResponsePojo.getDriverFirstName() != null && !requestResponsePojo.getDriverFirstName().isEmpty()) {
			if (!requestResponsePojo.getDriverFirstName().matches(namewithSpacePattern)) {
				allErrors.add("Invalid Driver Name");
			}
		} else {
			allErrors.add("Please provide Driver Name");
		}
		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}

	}

	public void validateVehcilelistByStatus(RequestResponsePojo requestResponsePojo) throws ValidationFatalException {
		List<String> allErrors = new ArrayList<>();

		if (requestResponsePojo.getStatus() == null && requestResponsePojo.getStatus().isEmpty()) {
			allErrors.add("Please provide Status");
		}

		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}
	}

	public void validateDriverlistByStatus(RequestResponsePojo requestResponsePojo) throws ValidationFatalException {
		List<String> allErrors = new ArrayList<>();

		if (requestResponsePojo.getStatus() == null && requestResponsePojo.getStatus().isEmpty()) {
			allErrors.add("Please provide Status");
		}

		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}
	}

	public void validateUpdateDriverStatusByAdmin(RequestResponsePojo requestResponsePojo)
			throws ValidationFatalException {
		List<String> allErrors = new ArrayList<>();

		if (requestResponsePojo.getDriverId() == 0) {
			allErrors.add("Please provide Driver Id");
		}
		if (requestResponsePojo.getStatus().isEmpty() && requestResponsePojo.getStatus() == null) {
			allErrors.add("Please provide Status");
		}
		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}
	}

	public void validateUpdateVehicleStatusByAdmin(RequestResponsePojo requestResponsePojo)
			throws ValidationFatalException {
		List<String> allErrors = new ArrayList<>();

		if (requestResponsePojo.getVehicleId() == 0) {
			allErrors.add("Please provide Vehicle Id");
		}
		if (requestResponsePojo.getStatus().isEmpty() && requestResponsePojo.getStatus() == null) {
			allErrors.add("Please provide Status");
		}

		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}
	}

	public void validateUpdateVehicleAdminRemark(RequestResponsePojo requestResponsePojo)
			throws ValidationFatalException {
		List<String> allErrors = new ArrayList<>();

		if (requestResponsePojo.getVehicleAdminRemark() == null
				& requestResponsePojo.getVehicleAdminRemark().isEmpty()) {
			allErrors.add("Please provide Remark by admin");
		}

		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}
	}

	public void validateupdateDriverAdminRemark(RequestResponsePojo requestResponsePojo)
			throws ValidationFatalException {
		List<String> allErrors = new ArrayList<>();
		if (requestResponsePojo.getDriverAdminRemark() == null & requestResponsePojo.getDriverAdminRemark().isEmpty()) {
			allErrors.add("Please provide Remark by admin");
		}

		if (allErrors.size() > 0) {
			throw new ValidationFatalException("validation failure; Invalid request", allErrors);
		}
	}

}

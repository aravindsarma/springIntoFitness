package com.jstartpro.springfit.dataentry;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;
import org.xmlunit.builder.Input;
import org.xmlunit.validation.Languages;
import org.xmlunit.validation.ValidationProblem;
import org.xmlunit.validation.ValidationResult;
import org.xmlunit.validation.Validator;


public class DataEntryTest {

	  @Test
	    public void givenXml_whenValidatesAgainstXsd_thenCorrect() {
	        Validator v = Validator.forLanguage(Languages.W3C_XML_SCHEMA_NS_URI);
	        v.setSchemaSource(Input.fromStream(DataEntryTest.class.getResourceAsStream("/dailyReportIn.xsd")).build());
	        ValidationResult r = v.validateInstance(Input.fromStream(DataEntryTest.class.getResourceAsStream("/dailyEntry_2016-4-8.xml")).build());
	        Iterator<ValidationProblem> probs = r.getProblems().iterator();
	        while (probs.hasNext()) {
	            System.out.println(probs.next().toString());
	        }
	        assertTrue(r.isValid());
	    }

}

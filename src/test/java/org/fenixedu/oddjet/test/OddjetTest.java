package org.fenixedu.oddjet.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.fenixedu.oddjet.Template;
import org.fenixedu.oddjet.table.CategoricalTableData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OddjetTest {

    @Test
    public void doIt() throws Exception {
        Template t = new Template("./src/test/resources/test1.odt");
        t.addParameter("title1", "Person Registry");
        t.addParameter("title2", "Courses Registry");

        HashMap<String, List> tdata = new HashMap<>();
        List<Object> name = new ArrayList<>();
        name.add("Mariana");
        name.add("João");
        name.add("Marta");
        name.add("José");
        List<Object> gender = new ArrayList<>();
        gender.add("F");
        gender.add("M");
        gender.add("F");
        gender.add("M");
        List<Object> age = new ArrayList<>();
        age.add(new Integer(21));
        age.add(new Integer(25));
        age.add(new Integer(28));
        age.add(new Integer(21));
        List<Object> dob = new ArrayList<>();
        dob.add("08/25/1990");
        dob.add("12/25/1991");
        dob.add("02/14/1993");
        dob.add("05/10/1989");
        tdata.put("name", name);
        tdata.put("dob", dob);
        tdata.put("age", age);
        tdata.put("gender", gender);

        HashMap<String, List> tdata2 = new HashMap<>();
        List<Object> course = new ArrayList<>();
        course.add("OpenOffice");
        course.add("Microsoft Office");
        course.add("Eclipse");
        course.add("NetBeans");
        List<Object> price = new ArrayList<>();
        price.add("190€");
        price.add("800€");
        price.add("100€");
        price.add("130€");
        List<Object> exam = new ArrayList<>();
        exam.add("08/25");
        exam.add("12/25");
        exam.add("02/14");
        exam.add("05/10");
        tdata2.put("course", course);
        tdata2.put("price", price);
        tdata2.put("exam", exam);

        t.addTableDataSource("person", new CategoricalTableData(tdata));
        t.addTableDataSource("courses", new CategoricalTableData(tdata2));

        t.saveInstance("./target/test1Inst.odt");
    }
}

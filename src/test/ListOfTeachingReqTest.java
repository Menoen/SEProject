import main.java.ListOfTeachingReq;
import main.java.TeachingRequirement;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Auther: Weiwei Zhao
 * @Matric: 2586561Z
 * @Date: 1:59 2021/5/23
 * @Desc:
 */
public class ListOfTeachingReqTest {
    public static void main(String[] args) {
        // singleton pattern
        ListOfTeachingReq reqList = ListOfTeachingReq.instance();
        TeachingRequirement req = new TeachingRequirement();
        req.setCourseName("Japanese");
        req.setRequirementSkill(new String[]{"Language","Japanese"});
        req.setRequirementName("J1");
        req.setRequirementStaffNumber(100);
        System.out.println(req.toString());
        // Test for add()
        reqList.add(req);
        // test for getter
        ArrayList<TeachingRequirement> arrayList = ListOfTeachingReq.getListTeachingRequirement();
        for (TeachingRequirement req1: arrayList){
            System.out.println(req1.getRequirementStaffNumber());
            System.out.println(Arrays.toString(req1.getRequirementSkill()));
            System.out.println(req1.getRequirementName());
            System.out.println(req1.getCourseName());
        }
    }
}
package za.co.andre.proofskills.interviewassignment.helper;

import java.util.Comparator;
import za.co.andre.proofskills.interviewassignment.data.Employee;

/**
 *
 * @author Andr&eacute; Labuschagn&eacute; <andre@ParanoidAndroid.co.za>
 */
public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        if(e1.getUser().getFirst_name().compareTo(e2.getUser().getFirst_name()) == 0) {
            if(e1.getUser().getLast_name().compareTo(e2.getUser().getLast_name()) == 0) {
                return Integer.compare(e1.getUser().getId(), e2.getUser().getId());
            } else {
                return e1.getUser().getLast_name().compareTo(e2.getUser().getLast_name());
            }
        } else {
            return e1.getUser().getFirst_name().compareTo(e2.getUser().getFirst_name());
        }
    }   
}

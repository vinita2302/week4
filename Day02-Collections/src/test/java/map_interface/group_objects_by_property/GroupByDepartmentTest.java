package map_interface.group_objects_by_property;



import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GroupByDepartmentTest {

    @Test
    void testGroupByDepartment() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> groupedEmployees = GroupByDepartment.groupByDepartment(employees);

        assertEquals(2, groupedEmployees.size(), "Should contain 2 distinct departments");
        assertEquals(2, groupedEmployees.get("HR").size(), "HR should have 2 employees");
        assertEquals(1, groupedEmployees.get("IT").size(), "IT should have 1 employee");
    }
}

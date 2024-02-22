package lab1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

class GroupByFunction implements Function<Student[], Map<String, List<Student>>> {
    @Override
    public Map<String, List<Student>> apply(Student[] students) {
        Map<String, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            String group = student.getGroup();
            if (!groupedStudents.containsKey(group)) {
                groupedStudents.put(group, new ArrayList<>());
            }
            groupedStudents.get(group).add(student);
        }
        return groupedStudents;
    }
}


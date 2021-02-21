package db.test;

public enum Query {
    GET_ALL_EMPLOYEES("SELECT last_name, department_id, salary FROM demo.employees"),
    GET_ALL_EMP_JOIN_WITH_DEPARTMENT("SELECT t1.last_name, t1.department_id, t1.salary, t2.department_name FROM demo.employees t1 LEFT JOIN demo.departments t2 ON t1.department_id=t2.department_id"),
    GET_AVERAGE_SALARY("SELECT t1.department_id, t2.department_name, AVG(salary) FROM demo.employees t1 LEFT JOIN demo.departments t2 ON t1.department_id=t2.department_id WHERE t1.department_id IS NOT NULL GROUP BY t1.department_id");


    private String query;
    private Query(String query){
        this.query = query;
    }

    public String value(){
        return query;
    }
}

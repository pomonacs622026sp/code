public interface Enrollable {
    void enrollInCourse(String course);
    void withdrawFromCourse(String course);
    void viewCourseSchedule();
    
    default int getMaxCredits(){
        return 4;
    }

}

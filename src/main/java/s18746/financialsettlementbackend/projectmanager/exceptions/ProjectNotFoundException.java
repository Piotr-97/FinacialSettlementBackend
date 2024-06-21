package s18746.financialsettlementbackend.projectmanager.exceptions;

public class ProjectNotFoundException extends RuntimeException{

    public ProjectNotFoundException(String message) {
        super(message);
    }
}

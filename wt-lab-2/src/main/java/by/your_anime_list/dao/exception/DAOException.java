package by.your_anime_list.dao.exception;

import java.io.Serial;

public class DAOException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L; //this class isn't serializable, so mb I need to delete it

    public DAOException(){
        super();
    }

    public DAOException(String message){
        super(message);
    }

    public DAOException(Exception e){
        super(e);
    }

    public DAOException(String message, Exception e){
        super(message, e);
    }
}

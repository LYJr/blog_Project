package category.exceptoin;

//파일 시스템에 파일 저장 중 예외 상황에 대한 발생
public class FileStorageException extends RuntimeException {
    public FileStorageException(String message){
        super(message);
    }

    public FileStorageException(String message, Throwable cause){
        super(message, cause);
    }
}

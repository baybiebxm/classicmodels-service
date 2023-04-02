package sit.int204.classicmodels.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import sit.int204.classicmodels.exceptions.ErrorResponse;
import sit.int204.classicmodels.exceptions.ResourceNotFound;
import sit.int204.classicmodels.services.FileService;

import java.io.FileNotFoundException;
import java.time.DateTimeException;

@RestController
@RequestMapping("/api/files")
public class FileController {
    private final FileService fileService;
    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = fileService.loadFileAsResource(filename);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(file);
    }
    @PostMapping("")
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        fileService.store(file);
        return "You successfully uploaded " + file.getOriginalFilename() + "!";
    }

//    @ExceptionHandler(FileNotFoundException.class)  // ถ้าเจอ exception ตรงนี้ให้มาทำอันนี้
//    @ResponseStatus(HttpStatus.NOT_FOUND)
////    public ResourceNotFound handleFileNotFound(Exception ex){
////        ResourceNotFound rnf = new ResourceNotFound(ex.getMessage());
////        return rnf;
////    }
//    public ResponseEntity<ErrorResponse> handleFileNotFound(Exception ex, WebRequest request){
//        ErrorResponse er = new ErrorResponse(
//                HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false).substring(4)
//        );
//        er.addValidationError("field 1", "error 1");
//        er.addValidationError("field 2", "error 2");
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
//    }
//
//    @ExceptionHandler(NullPointerException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<ErrorResponse> handleNullPointer(RuntimeException exception, WebRequest request){
//        ErrorResponse er = new ErrorResponse(
//                HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getDescription(false).substring(4)
//        );
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
//    }
//
//    @ExceptionHandler(NumberFormatException.class)
//    public ResponseEntity<ErrorResponse> handleNumberFormat(RuntimeException exception, WebRequest request){
//        ErrorResponse er = new ErrorResponse(
//                HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getDescription(false).substring(4)
//        );
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
//    }

}

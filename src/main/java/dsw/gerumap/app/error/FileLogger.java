package dsw.gerumap.app.error;

import dsw.gerumap.app.message.EventType;
import dsw.gerumap.app.message.Message;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileLogger implements Logger {

    String text;
    List<String> errors;

    public FileLogger () {
        errors = new ArrayList<>();
    }

    @Override
    public void log(Message message) {
        EventType et = message.getType();
        Date date = new Date();

        text = "[" + et.toString() + "] [" + date +"] " + message.getContent() + "\n";
        errors.add(text);

        writeInFile(errors);
    }

    public void writeInFile(List<String> errors){
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/resources/log.txt"), "UTF-8"))){
            for (String s: errors) {
                writer.write(s);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

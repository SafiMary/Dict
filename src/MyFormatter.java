import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
class MyFormatter extends Formatter {//переопределили класс формат

    String pattern = "dd.MM.yyyy/hh:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String date = simpleDateFormat.format(new Date());
    @Override
    public String format(LogRecord record) {
        return record.getLevel()+": "+date +"***"+ record.getMessage()+"***" + "\n";
    }
}
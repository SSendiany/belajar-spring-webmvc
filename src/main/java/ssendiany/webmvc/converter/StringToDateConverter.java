package ssendiany.webmvc.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StringToDateConverter implements Converter<String, Date> {

  private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  
  @Override
  public Date convert(String source) {
    try {
      return dateFormat.parse(source);
    } catch (ParseException e) {
      log.warn("Error convert date from string {}", source, e);
      return null;
    }
  }

}

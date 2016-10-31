package com.epam.springadv.rest;

import com.epam.springadv.model.entities.Booking;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import javax.servlet.ServletOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexey on 30.10.2016.
 */
public class BookingPdfHttpMessageConverter implements HttpMessageConverter<List<Booking>> {
    @Override
    public boolean canRead(Class<?> aClass, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> aClass, MediaType mediaType) {
        return true;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Arrays.asList(MediaType.APPLICATION_PDF);
    }

    @Override
    public List<Booking> read(Class<? extends List<Booking>> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(List<Booking> bookings, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream(4096);
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, os);
            writer.setViewerPreferences(2053);
            document.open();

            Table table = new Table(3);
            table.addCell("Movie");
            table.addCell("Time");
            table.addCell("Price");

            for(Booking booking : bookings) {
                table.addCell(booking.getEvent().getMovie().getTitle());
                table.addCell(booking.getEvent().getScheduledTime().toString());
                table.addCell(booking.getPrice().toString());
            }

            document.add(table);
            document.close();
            writer.flush();

            httpOutputMessage.getHeaders().setContentType(MediaType.APPLICATION_PDF);
            httpOutputMessage.getHeaders().setContentLength(os.size());
            os.writeTo(httpOutputMessage.getBody());
            httpOutputMessage.getBody().flush();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}

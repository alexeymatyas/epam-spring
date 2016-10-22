package com.epam.springadv.mvc.views;

import com.epam.springadv.model.entities.Booking;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexey on 22.10.2016.
 */
public class UserBookingsListPdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map model, Document document, PdfWriter pdfWriter,
                                    HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {

        List<Booking> bookings = (List<Booking>) model.get("bookings");

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
    }
}

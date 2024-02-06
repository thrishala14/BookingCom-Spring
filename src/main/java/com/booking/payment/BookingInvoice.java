package com.booking.payment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Invoice;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*")
public class BookingInvoice {

	@PostMapping("/invoice")
	public String generateInvoice() throws RazorpayException {
		System.out.println("hello");
		RazorpayClient razorpay = new RazorpayClient("rzp_test_CWpizXcUOhqswA", "C0lQ3oMRdZR0QGtS3gMpGKZ8");

		JSONObject invoiceRequest = new JSONObject();
		invoiceRequest.put("type", "invoice");
		invoiceRequest.put("description", "Invoice for the month of January 2020");
		invoiceRequest.put("partial_payment",true);
		JSONObject customer = new JSONObject();
		customer.put("name","Gaurav Kumar");
		customer.put("contact","9000090000");
		customer.put("email","gaurav.kumar@example.com");
		JSONObject billingAddress = new JSONObject();
		billingAddress.put("line1","Ground & 1st Floor, SJR Cyber Laskar");
		billingAddress.put("line2","Hosur Road");
		billingAddress.put("zipcode","560068");
		billingAddress.put("city","Bengaluru");
		billingAddress.put("state","Karnataka");
		billingAddress.put("country","in");
		customer.put("billing_address",billingAddress);
		JSONObject shippingAddress = new JSONObject();
		shippingAddress.put("line1","Ground & 1st Floor, SJR Cyber Laskar");
		shippingAddress.put("line2","Hosur Road");
		shippingAddress.put("zipcode","560068");
		shippingAddress.put("city","Bengaluru");
		shippingAddress.put("state","Karnataka");
		shippingAddress.put("country","in");
		customer.put("shipping_address",shippingAddress);
		invoiceRequest.put("customer",customer);
		List<Object> lines = new ArrayList<>();
		JSONObject lineItems = new JSONObject();
		lineItems.put("name","Master Cloud Computing in 30 Days");
		lineItems.put("description","Book by Ravena Ravenclaw");
		lineItems.put("amount",399);
		lineItems.put("currency","INR");
		lineItems.put("quantity",1);
		lines.add(lineItems);
		invoiceRequest.put("line_items",lines);
		invoiceRequest.put("email_notify", 1);
		invoiceRequest.put("sms_notify", 1);
		invoiceRequest.put("currency","INR");
		invoiceRequest.put("expire_by", 4765046399L);

		Invoice invoice = razorpay.invoices.create(invoiceRequest);
		return "Success";
	}
}

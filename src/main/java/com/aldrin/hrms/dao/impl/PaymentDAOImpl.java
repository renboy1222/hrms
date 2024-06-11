/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.dao.impl;

import com.aldrin.hrms.dao.PaymentDAO;
import static com.aldrin.hrms.dao.impl.DBConnection.closeConnection;
import static com.aldrin.hrms.dao.impl.DBConnection.getCon;
import com.aldrin.hrms.model.Bill;
import com.aldrin.hrms.model.Booking;
import com.aldrin.hrms.model.Customer;
import com.aldrin.hrms.model.Duration;
import com.aldrin.hrms.model.Payment;
import com.aldrin.hrms.model.Room;
import com.aldrin.hrms.model.RoomRate;
import com.aldrin.hrms.model.RoomStatus;
import com.aldrin.hrms.model.RoomType;
import com.aldrin.hrms.model.Storey;
import com.aldrin.hrms.util.ComboBoxList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
public class PaymentDAOImpl extends DBConnection implements PaymentDAO {
    
    @Override
    public void addPayment(Payment payment) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
INSERT INTO `payment` (
  `user_id`,
  `bill_id`,
   `amount`
) VALUES(?,?,?) ;
                                                                      """);
            ps.setLong(1, payment.getUser().getId());
            ps.setLong(2, payment.getBill().getId());
            ps.setFloat(3, payment.getAmount());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void updatePayment(Payment payment) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
UPDATE 
   `payment` 
SET  
  `user_id` = ?,
  `bill_id` = ?,
   `amount` = ? 
WHERE `id` = ?;
                                                                      """);
            ps.setLong(1, payment.getUser().getId());
            ps.setLong(2, payment.getBill().getId());
            ps.setFloat(3, payment.getAmount());
            ps.setLong(4, payment.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void deletePayment(Payment customer) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
                                                                      UPDATE 
                                                                        `customer`
                                                                      SET
                                                                        `deleted` = CURRENT_TIMESTAMP()
                                                                      WHERE `id` = ? ;
                                                                      """);
            ps.setLong(1, customer.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<ComboBoxList> list;
    
    @Override
    public Payment selectRoomBookingPayments(Long roomId) {
        Payment list = new Payment();
        try {
            String query = "SELECT\n"
                    + "    `room`.`room_number`\n"
                    + "    , `duration`.`duration`\n"
                    + "    , `room_rate`.`price`\n"
                    + "    , `room_rate`.`down_payment`\n"
                    + "    , `room_rate`.`refundable`\n"
                    + "    , `booking`.`check_in_date`\n"
                    + "    , `booking`.`check_out_date`\n"
                    + "    , `payment`.`amount`\n"
                    + "    , (`room_rate`.`price`-SUM(`payment`.`amount`)) AS insufficient \n"
                    + "    , `booking`.`created_at` \n"
                    + "    , `customer`.`name`\n"
                    + "FROM\n"
                    + "    `hrms`.`room_rate`\n"
                    + "    INNER JOIN `hrms`.`room` \n"
                    + "        ON (`room_rate`.`room_id` = `room`.`id`)\n"
                    + "    INNER JOIN `hrms`.`duration` \n"
                    + "        ON (`room_rate`.`duration_id` = `duration`.`id`)\n"
                    + "    INNER JOIN `hrms`.`booking` \n"
                    + "        ON (`booking`.`room_rate_id` = `room_rate`.`id`)\n"
                    + "    INNER JOIN `hrms`.`bill` \n"
                    + "        ON (`booking`.`bill_id` = `bill`.`id`)\n"
                    + "    INNER JOIN `hrms`.`payment` \n"
                    + "        ON (`payment`.`bill_id` = `bill`.`id`)\n"
                    + "    INNER JOIN `hrms`.`customer` \n"
                    + "        ON (`bill`.`customer_id` = `customer`.`id`) WHERE  `booking`.`check_out_date`< CURRENT_TIMESTAMP()  AND `room`.`id` =" + roomId + "\n"
                    + "        \n"
                    + "    GROUP BY      `room`.`room_number`\n"
                    + "    , `duration`.`duration`\n"
                    + "    , `room_rate`.`price`\n"
                    + "    , `room_rate`.`down_payment`\n"
                    + "    , `room_rate`.`refundable`\n"
                    + "    , `booking`.`check_in_date`\n"
                    + "    , `booking`.`check_out_date`\n"
                    + "    , `payment`.`amount` \n"
                    + "    , `booking`.`created_at` \n"
                    + "    , `customer`.`name` ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Payment payment = new Payment();
                Duration duration = new Duration();
                RoomRate roomRate = new RoomRate();
                Booking booking = new Booking();
                Customer customer = new Customer();
                RoomStatus roomStatus = new RoomStatus();
                Storey storey = new Storey();
                RoomType roomType = new RoomType();
                Bill bill = new Bill();
                Room room = new Room();
                duration.setDuration(rs.getString("DURATION"));
                roomRate.setPrice(rs.getFloat("PRICE"));
                roomRate.setDown_payment(rs.getFloat("DOWN_PAYMENT"));
                roomRate.setRefundable(rs.getFloat("REFUNDABLE"));
                booking.setCheckInDate(rs.getDate("CHECK_IN_DATE"));
                booking.setCheckOutDate(rs.getDate("CHECK_OUT_DATE"));
                payment.setAmount(rs.getFloat("AMOUNT"));
                booking.setCreatedAt(rs.getDate("CREATED_AT"));
                customer.setName(rs.getString("NAME"));
//                roomStatus.setStatus(rs.getString("STATUS"));
//                storey.setStorey(rs.getString("STOREY"));
//                roomType.setType(rs.getString("TYPE"));

                room.setRoomStatus(roomStatus);
                room.setRoomType(roomType);
                room.setStorey(storey);
                roomRate.setRoom(room);
                roomRate.setDuration(duration);
                booking.setRoomRate(roomRate);
                bill.setCustomer(customer);
                booking.setBill(bill);
                payment.setBill(bill);
                
                list = payment;
                
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    @Override
    public void comboBoxInvoiceId() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `created_at`,DATE_FORMAT(`created_at`, '%b %d,%Y %h:%i:%p') AS createAT \n"
                    + "FROM\n"
                    + "  `hrms`.`payment` ORDER BY id DESC ;");
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                String createdAT = rs.getString("createAT");
                this.getList().add(new ComboBoxList(idl, idl + "    [" + createdAT + "]"));
            }
            rs.close();
            statement.close();
            closeConnection();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public ArrayList<Payment> selectUserReceiveAmount(Long userId, Long from, Long to) {
        ArrayList<Payment> list = new ArrayList<>();
        try {
            String query = """
                           SELECT
                               `user`.`firstname`
                               , `user`.`surname`
                               , `customer`.`name`
                               , `payment`.`id`
                               , `payment`.`created_at`
                               , `payment`.`amount`
                           FROM
                               `hrms`.`payment`
                               INNER JOIN `hrms`.`user` 
                                   ON (`payment`.`user_id` = `user`.`id`)
                               INNER JOIN `hrms`.`bill` 
                                   ON (`payment`.`bill_id` = `bill`.`id`)
                               INNER JOIN `hrms`.`customer` 
                                   ON (`bill`.`customer_id` = `customer`.`id`)
                               INNER JOIN `hrms`.`booking` 
                                   ON (`booking`.`bill_id` = `bill`.`id`)
                           """ + " WHERE `user`.`id` =" + userId + " AND `payment`.`id` >=" + from + " AND `payment`.`id` <=" + to + "  ORDER BY `payment`.`id` ASC  ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                Payment p = new Payment();
                Bill bill = new Bill();
                Customer customer = new Customer();
                p.setId(rs.getLong("ID"));
                customer.setName(rs.getString("NAME"));
                bill.setCustomer(customer);
                p.setCreatedAtF(rs.getString("CREATED_AT"));
                p.setAmount(rs.getFloat("AMOUNT"));
                p.setBill(bill);
                
                list.add(p);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.hrms.dao.impl;

import com.aldrin.hrms.dao.BookingDAO;
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
import com.aldrin.hrms.util.StringToDate;
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
public class BookingDAOImpl extends DBConnection implements BookingDAO {

    @Override
    public void addBooking(Booking booking) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
INSERT INTO `booking` (
  `check_in_date`,
  `check_out_date`,
  `room_rate_id`,
  `bill_id`
) 
VALUES
  (?,?,?,?) ;
                                                                      """);
            String checkInDate = new StringToDate().convertDateToString(booking.getCheckInDate());
            String checkOutDate = new StringToDate().convertDateToString(booking.getCheckOutDate());
            ps.setString(1, checkInDate);
            ps.setString(2, checkOutDate);
            ps.setLong(3, booking.getRoomRate().getId());
            ps.setLong(4, booking.getBill().getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBookingReserve(Booking booking) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
INSERT INTO `booking` (
  `check_in_date`,
  `check_out_date`,
  `reserve`,
  `room_rate_id`,
  `bill_id`
) 
VALUES
  (?,?,CURRENT_TIMESTAMP(),?,?) ;
                                                                      """);
            String checkInDate = new StringToDate().convertDateToString(booking.getCheckInDate());
            String checkOutDate = new StringToDate().convertDateToString(booking.getCheckOutDate());
            ps.setString(1, checkInDate);
            ps.setString(2, checkOutDate);
            ps.setLong(3, booking.getRoomRate().getId());
            ps.setLong(4, booking.getBill().getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBooking(Booking customer) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("""
UPDATE 
  `customer` 
SET
  `address` = ?,
  `email` = ?,
  `name` = ?,
  `phone` = ? 
WHERE `customer_id` = ? 
                                                                      """);
//            ps.setLong(1, customer.getCustomer().getId());
            ps.setLong(5, customer.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBooking(Booking customer) {
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
    public Long getMaxId() {
        Long maxId = null;
        try {
            getDBConn();
            PreparedStatement statement = getCon().prepareStatement("""
                              SELECT 
                                                                      MAX(`id`) AS ID
                                                                    FROM
                                                                      `hrms`.`booking`                                       
                                                                    """);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                if (idl == 0) {
                    maxId = 1L;
                } else {
                    maxId = idl + 1;
                }
            }
            rs.close();
            statement.close();
//            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxId;
    }

    @Override
    public Booking selectRoomBookingByRoomId(Long roomId) {
        Booking list = new Booking();
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
                    + "    , `bill`.`id`\n"
                    + "    , `room_status`.`status`\n"
                    + "    , `room_storey`.`storey`\n"
                    + "    , `room_type`.`type`, `booking`.`reserve`\n"
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
                    + "        ON (`bill`.`customer_id` = `customer`.`id`)\n"
                    + "    INNER JOIN `hrms`.`room_storey` \n"
                    + "        ON (`room`.`storey_id` = `room_storey`.`id`)\n"
                    + "    INNER JOIN `hrms`.`room_type` \n"
                    + "        ON (`room`.`type_id` = `room_type`.`id`)\n"
                    + "    INNER JOIN `hrms`.`room_status` \n"
                    + "        ON (`room`.`status_id` = `room_status`.`id`)        \n"
                    + "    WHERE  `booking`.`check_out_date`> CURRENT_TIMESTAMP()  AND `room`.`id` = " + roomId + " \n"
                    + "    GROUP BY `room`.`room_number`\n"
                    + "    , `duration`.`duration`\n"
                    + "    , `room_rate`.`price`\n"
                    + "    , `room_rate`.`down_payment`\n"
                    + "    , `room_rate`.`refundable`\n"
                    + "    , `booking`.`check_in_date`\n"
                    + "    , `booking`.`check_out_date`\n"
                    + "    , `payment`.`amount`\n"
                    + "    , `bill`.`id`\n"
                    + "    , `room_status`.`status`\n"
                    + "    , `room_storey`.`storey`\n"
                    + "    , `room_type`.`type`, `booking`.`reserve` ORDER BY `room`.`room_number` ASC ";
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
                booking.setCheckIn(rs.getString("CHECK_IN_DATE"));
                booking.setCheckOut(rs.getString("CHECK_OUT_DATE"));
                if (rs.getDate("RESERVE") == null) {
                    booking.setReserve(null);
                } else {
                    booking.setReserve(rs.getDate("RESERVE"));
                }
                payment.setAmount(rs.getFloat("AMOUNT"));
                bill.setId(rs.getLong("ID"));
                roomStatus.setStatus(rs.getString("STATUS"));
                storey.setStorey(rs.getString("STOREY"));
                roomType.setType(rs.getString("TYPE"));

                room.setRoomStatus(roomStatus);
                room.setRoomType(roomType);
                room.setStorey(storey);
                roomRate.setRoom(room);
                roomRate.setDuration(duration);
                booking.setRoomRate(roomRate);
                bill.setCustomer(customer);
                booking.setBill(bill);
                payment.setBill(bill);

                list = booking;

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
    public Booking selectRoomBookingByRoomIdAndCheckOutAndCheckIn(Long roomId, String checkIn, String checkOut) {
        Booking list = new Booking();
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
                    + "    , `bill`.`id`\n"
                    + "    , `room_status`.`status`\n"
                    + "    , `room_storey`.`storey`\n"
                    + "    , `room_type`.`type`, `booking`.`reserve`\n"
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
                    + "        ON (`bill`.`customer_id` = `customer`.`id`)\n"
                    + "    INNER JOIN `hrms`.`room_storey` \n"
                    + "        ON (`room`.`storey_id` = `room_storey`.`id`)\n"
                    + "    INNER JOIN `hrms`.`room_type` \n"
                    + "        ON (`room`.`type_id` = `room_type`.`id`)\n"
                    + "    INNER JOIN `hrms`.`room_status` \n"
                    + "        ON (`room`.`status_id` = `room_status`.`id`)        \n"
                    + "    WHERE  `booking`.`check_out_date`> CURRENT_TIMESTAMP()  AND `room`.`id` = " + roomId + " AND `booking`.`check_in_date`< '" + checkIn + "' AND  `booking`.`check_out_date`> '" + checkOut + "' \n"
                    + "    GROUP BY `room`.`room_number`\n"
                    + "    , `duration`.`duration`\n"
                    + "    , `room_rate`.`price`\n"
                    + "    , `room_rate`.`down_payment`\n"
                    + "    , `room_rate`.`refundable`\n"
                    + "    , `booking`.`check_in_date`\n"
                    + "    , `booking`.`check_out_date`\n"
                    + "    , `payment`.`amount`\n"
                    + "    , `bill`.`id`\n"
                    + "    , `room_status`.`status`\n"
                    + "    , `room_storey`.`storey` , `booking`.`reserve`\n"
                    + "    , `room_type`.`type` ORDER BY `room`.`room_number` ASC ";
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
                booking.setCheckIn(rs.getString("CHECK_IN_DATE"));
                booking.setCheckOut(rs.getString("CHECK_OUT_DATE"));
                if (rs.getDate("RESERVE") == null) {
                    booking.setReserve(null);
                } else {
                    booking.setReserve(rs.getDate("RESERVE"));
                }
                payment.setAmount(rs.getFloat("AMOUNT"));
                bill.setId(rs.getLong("ID"));
                roomStatus.setStatus(rs.getString("STATUS"));
                storey.setStorey(rs.getString("STOREY"));
                roomType.setType(rs.getString("TYPE"));

                room.setRoomStatus(roomStatus);
                room.setRoomType(roomType);
                room.setStorey(storey);
                roomRate.setRoom(room);
                roomRate.setDuration(duration);
                booking.setRoomRate(roomRate);
                bill.setCustomer(customer);
                booking.setBill(bill);
                payment.setBill(bill);

                list = booking;

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
    public ArrayList<Booking> selectRoomBookingListByRoomId(Long roomId) {
        ArrayList<Booking> list = new ArrayList<Booking>();
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
                    + "    , `bill`.`id`\n"
                    + "    , `room_status`.`status`\n"
                    + "    , `room_storey`.`storey`\n"
                    + "    , `room_type`.`type`, `booking`.`reserve`\n"
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
                    + "        ON (`bill`.`customer_id` = `customer`.`id`)\n"
                    + "    INNER JOIN `hrms`.`room_storey` \n"
                    + "        ON (`room`.`storey_id` = `room_storey`.`id`)\n"
                    + "    INNER JOIN `hrms`.`room_type` \n"
                    + "        ON (`room`.`type_id` = `room_type`.`id`)\n"
                    + "    INNER JOIN `hrms`.`room_status` \n"
                    + "        ON (`room`.`status_id` = `room_status`.`id`)        \n"
                    + "    WHERE  `booking`.`check_out_date`> CURRENT_TIMESTAMP()  AND `room`.`id` = " + roomId + " \n"
                    + "    GROUP BY `room`.`room_number`\n"
                    + "    , `duration`.`duration`\n"
                    + "    , `room_rate`.`price`\n"
                    + "    , `room_rate`.`down_payment`\n"
                    + "    , `room_rate`.`refundable`\n"
                    + "    , `booking`.`check_in_date`\n"
                    + "    , `booking`.`check_out_date`\n"
                    + "    , `payment`.`amount`\n"
                    + "    , `bill`.`id`\n"
                    + "    , `room_status`.`status`\n"
                    + "    , `room_storey`.`storey`\n"
                    + "    , `room_type`.`type`, `booking`.`reserve` ORDER BY `room`.`room_number` ASC ";
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
                booking.setCheckIn(rs.getString("CHECK_IN_DATE"));
                booking.setCheckOut(rs.getString("CHECK_OUT_DATE"));
                if (rs.getDate("RESERVE") == null) {
                    booking.setReserve(null);
                } else {
                    booking.setReserve(rs.getDate("RESERVE"));
                }
                payment.setAmount(rs.getFloat("AMOUNT"));
                bill.setId(rs.getLong("ID"));
                roomStatus.setStatus(rs.getString("STATUS"));
                storey.setStorey(rs.getString("STOREY"));
                roomType.setType(rs.getString("TYPE"));

                room.setRoomStatus(roomStatus);
                room.setRoomType(roomType);
                room.setStorey(storey);
                roomRate.setRoom(room);
                roomRate.setDuration(duration);
                booking.setRoomRate(roomRate);
                bill.setCustomer(customer);
                booking.setAmount(payment.getAmount());
                
                booking.setBill(bill);
                payment.setBill(bill);
                list.add(booking);
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
    public ArrayList<Payment> selectRoomBookingPaymentListByRoomId(Long roomId) {
        ArrayList<Payment> list = new ArrayList<Payment>();
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
                    + "    , `bill`.`id`\n"
                    + "    , `room_status`.`status`\n"
                    + "    , `room_storey`.`storey`\n"
                    + "    , `room_type`.`type`, `booking`.`reserve`\n"
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
                    + "        ON (`bill`.`customer_id` = `customer`.`id`)\n"
                    + "    INNER JOIN `hrms`.`room_storey` \n"
                    + "        ON (`room`.`storey_id` = `room_storey`.`id`)\n"
                    + "    INNER JOIN `hrms`.`room_type` \n"
                    + "        ON (`room`.`type_id` = `room_type`.`id`)\n"
                    + "    INNER JOIN `hrms`.`room_status` \n"
                    + "        ON (`room`.`status_id` = `room_status`.`id`)        \n"
                    + "    WHERE  `booking`.`check_out_date`> CURRENT_TIMESTAMP()  AND `room`.`id` = " + roomId + " \n"
                    + "    GROUP BY `room`.`room_number`\n"
                    + "    , `duration`.`duration`\n"
                    + "    , `room_rate`.`price`\n"
                    + "    , `room_rate`.`down_payment`\n"
                    + "    , `room_rate`.`refundable`\n"
                    + "    , `booking`.`check_in_date`\n"
                    + "    , `booking`.`check_out_date`\n"
                    + "    , `payment`.`amount`\n"
                    + "    , `bill`.`id`\n"
                    + "    , `room_status`.`status`\n"
                    + "    , `room_storey`.`storey`\n"
                    + "    , `room_type`.`type`, `booking`.`reserve` ORDER BY `room`.`room_number` ASC ";
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
                booking.setCheckIn(rs.getString("CHECK_IN_DATE"));
                booking.setCheckOut(rs.getString("CHECK_OUT_DATE"));
                if (rs.getDate("RESERVE") == null) {
                    booking.setReserve(null);
                } else {
                    booking.setReserve(rs.getDate("RESERVE"));
                }
                payment.setAmount(rs.getFloat("AMOUNT"));
                bill.setId(rs.getLong("ID"));
                roomStatus.setStatus(rs.getString("STATUS"));
                storey.setStorey(rs.getString("STOREY"));
                roomType.setType(rs.getString("TYPE"));

                room.setRoomStatus(roomStatus);
                room.setRoomType(roomType);
                room.setStorey(storey);
                roomRate.setRoom(room);
                roomRate.setDuration(duration);
                booking.setRoomRate(roomRate);
                bill.setCustomer(customer);
                booking.setBill(bill);
                payment.setBill(bill);
                list.add(payment);
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

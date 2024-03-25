/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.business;
import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author nguye
 */
@Entity
@Table(name = "payment")
public class Payment implements Serializable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "amount")
    private String amount;
    @Basic
    @Column(name = "bankcode")
    private String bankcode;
    @Basic
    @Column(name = "orderinfo")
    private String orderinfo;
    @Basic
    @Column(name = "paydate")
    private String paydate;
    @Basic
    @Column(name = "txnref")
    private String txnref;
    @Basic
    @Column(name = "transactionno")
    private String transactionno;
    @Basic
    @Column(name = "transactionstatus")
    private String transactionstatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public String getOrderinfo() {
        return orderinfo;
    }

    public void setOrderinfo(String orderinfo) {
        this.orderinfo = orderinfo;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public String getTxnref() {
        return txnref;
    }

    public void setTxnref(String txnref) {
        this.txnref = txnref;
    }

    public String getTransactionno() {
        return transactionno;
    }

    public void setTransactionno(String transactionno) {
        this.transactionno = transactionno;
    }

    public String getTransactionstatus() {
        return transactionstatus;
    }

    public void setTransactionstatus(String transactionstatus) {
        this.transactionstatus = transactionstatus;
    }


    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.kdt;

/**
 *
 * @author w
 */
public class Information {
    private String id;
    private String receiver;
    private String code;
    private String phone;
    private String address;
    private String way;
    private String size;
    private String type;
    private String cost;
    private String userName;
    private String condition;
    private String jiedan;
    
    public String getJiedan(){
    return jiedan;}
    
    public void setJiedan(String jiedan){
    
        this.jiedan=jiedan;}
    
    public String getId(){
    return id;}
    
    public void setId(String id)
    {
        this.id=id;
    }
    
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
   
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }
    
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    } 
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
   @Override
	public String toString() {
		return "Information [receiver=" + receiver + ", code=" + code + ", phone=" + phone + ", address=" + address + ",way=" + way + ", size=" + size + ", type="+type+", cost="+cost+",username="+userName+",condition="+condition+"]";
	}
        
        public Information(String receiver,String code,String phone,String address,String way,String size,String type,String cost,String userName,String condition)
        {
            super();
            this.receiver=receiver;
            this.code=code;
            this.phone=phone;
            this.address=address;
            this.way=way;
            this.size=size;
            this.type=type;
            this.cost=cost;
            this.userName=userName;
            this.condition=condition;
        }
        
        public Information(){
        super();
        }
       

}

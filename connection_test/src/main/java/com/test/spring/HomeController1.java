package com.test.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.spring.dto.Dto;

@Controller
public class HomeController1 {
	@RequestMapping("/home")
	public String goHome(Model model) {
		String query = new String("select * from test");
		ArrayList<Dto> dtos = new ArrayList<>();
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/Oracle11g");
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conn = ds.getConnection();
				System.out.println("connection success!!");
				stmt = conn.prepareStatement(query);
				rs = stmt.executeQuery();
				while(rs.next()) {
					String id = rs.getString("id");
					String pw = rs.getString("pw");
					System.out.println(id + pw);
					Dto dto = new Dto(id, pw);
					dtos.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
					try {
						if(rs!=null) rs.close();
						if(stmt!=null) stmt.close();
						if(conn!=null) conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		}catch(NamingException e) {
			e.printStackTrace();
		}
		model.addAttribute("list",dtos);
		return "home";
	}
}

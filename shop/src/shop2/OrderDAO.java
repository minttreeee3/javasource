package shop2;

import static shop2.JdbcUtil.*;	//JdbcUtil 클래스 : 드라이버로드, connection, close반복작업을 하나의 클래스에 정의해둠 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class OrderDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	// CRUD (create/ read=select/ update/ delete) 메소드 작성
	
	
	// 장바구니 ==> sorder 테이블에 추가하는(insert) 개념으로	
	public boolean insert(int userId, int productId) {
		
		boolean status = false;
		
		try {
			con = getConnection();
			
			String sql = "INSERT INTO sorder(order_id, user_id, product_id, order_date) VALUES(order_seq.NEXTVAL, ?, ?, SYSDATE)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, productId);
			
			int result = pstmt.executeUpdate();
			if (result>0) status=true;
						
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return status;
	} //insert끝
	
	
	// 장바구니 조회 - 특정 회원
	public List<OrderDTO> carts(int userId) {
		List<OrderDTO> list = new ArrayList<>();
		
		try {
			con = getConnection();
			
			String sql = " SELECT u.user_id, u.name, c.info, p.product_id, p.pname, p.price, p.content, o.order_date ";
				sql += "from suser u join paytype c on u.pay_no=c.pay_no join sorder o on u.user_id=o.user_id join product p on o.product_id=p.product_id ";
				sql	+= "where u.user_id=?";
				
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			
			rs = pstmt.executeQuery();
			
			// ResultSet결과 : user_id, name, info, product_id, pname, price, content, order_date ==> OrderDTO에 담기
			// user_id, name, info => UserDTO에 담기
			// product_id, pname, price, content => Product 객체 이용해서
			// order_date => OrderDTO
			while(rs.next()) {
				UserDTO userDTO = new UserDTO();
				userDTO.setUserId(rs.getInt(1)); //user_id
				userDTO.setName(rs.getString(2)); //name
				userDTO.setType(rs.getString(3)); //info
				
				ProductDTO productDTO = new ProductDTO();
				productDTO.setProductId(rs.getInt(4)); //product_id
				productDTO.setPname(rs.getString(5)); //pname
				productDTO.setPrice(rs.getInt(6)); //price
				productDTO.setContent(rs.getString(7)); //content
				
				OrderDTO orderDTO = new OrderDTO();
				orderDTO.setUserDTO(userDTO); //위에 usesrDTO에 담아둔것들
				orderDTO.setProductDTO(productDTO); //위에 productDTO에 담아둔것들
				orderDTO.setOrderDate(rs.getDate(8)); //order_date
				
				list.add(orderDTO);
				
			}
					
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
				
	} //carts 끝
	
	
	
	
	
	

}

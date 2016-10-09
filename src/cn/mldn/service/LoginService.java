package cn.mldn.service;

public class LoginService {
		public boolean login (String mid ,String password){
			return "mldn".equals(mid) && "hello".equals(password);
		}
}

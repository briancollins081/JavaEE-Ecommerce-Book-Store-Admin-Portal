package com.brian.store.adminportal.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.brian.store.adminportal.domain.security.Authority;
import com.brian.store.adminportal.domain.security.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false, unique = true)
	private Long id;

	private String username;
	private String password;
	private String firstName;
	private String lastName;

	@Column(name = "email", nullable = false, updatable = false, unique = true)
	private String email;
	private String phone;
	private boolean enable = true;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
	private ShoppingCart shoppingCart;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private List<UserShipping> userShippingList;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private List<UserPayment> userPaymentList;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<UserRole> userRoles=new HashSet<UserRole>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public Set<UserRole> getUserRole() {
		return userRoles;
	}
	public void setUserRole(Set<UserRole> userRole) {
		this.userRoles = userRole;
	}
	
	public List<UserShipping> getUserShippingList() {
		return userShippingList;
	}
	public void setUserShippingList(List<UserShipping> userShippingList) {
		this.userShippingList = userShippingList;
	}
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public void setUserPaymentList(List<UserPayment> userPaymentList) {
		this.userPaymentList = userPaymentList;
	}
	public List<UserPayment> getUserPaymentList() {
		return userPaymentList;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final Set<GrantedAuthority>authorities=new HashSet<GrantedAuthority>();
		userRoles.forEach(new Consumer<UserRole>() {
			public void accept(UserRole ur) {
				authorities.add(new Authority(ur.getRole().getName()));
			}
		});
		return authorities;
	}
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enable;
	}
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
}

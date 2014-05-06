package repository;

import java.util.List;

import model.Address;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String>{

	public Address addAddress(Address Address);

	public List<Address> listAllAddress();

	public void deleteAddress(Address Address);

	public Address updateAddress(Address Address);

	
}

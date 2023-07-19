package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Address;
import com.bilgeadam.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class AddressRepository implements ICrud<Address> {
    Session session;
    Transaction transaction;
    @Override
    public Address save(Address address) {
        try {
            session = HibernateUtility.getSESSION_FACTORY().openSession();
            System.out.println("Oturum açıldı.");
            transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
            System.out.println("Kayıt başarılı.");
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }finally {
            System.out.println("oturum kapanıyor...");
            session.close();
        }
        return address;
    }

    @Override
    public Address update(Address address) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public Optional<Address> findById(Long id) {
        return Optional.empty();
    }
}

package com.oc.api.dao;

import com.oc.api.model.beans.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Integer> {

    @Query(value ="SELECT * FROM public.reservation WHERE book_id = ? AND library_id = ?", nativeQuery = true)
    List<Reservation> findAllByBookIdAndLibraryId(int book_id, int library_id);

    @Query(value = "SELECT * FROM public.reservation WHERE book_id = ? AND library_id = ? AND registered_user_id = ?", nativeQuery = true )
    Optional<Reservation> findByBookAndLibraryAndRegisteredUser(int book_id, int library_id, int registered_user_id);
}

package com.digitalinoccation.one.conferenceroom.repository;

import com.digitalinoccation.one.conferenceroom.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}

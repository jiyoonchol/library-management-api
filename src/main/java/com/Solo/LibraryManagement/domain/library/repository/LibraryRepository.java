package com.Solo.LibraryManagement.domain.library.repository;

import com.Solo.LibraryManagement.domain.library.entity.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Long>  {
    Optional<Library> findByName(String name);
    Page<Library> findAllByOrderByLibraryIdDesc(Pageable pageable);
}

package com.Solo.LibraryManagement.domain.library.repository;

import com.Solo.LibraryManagement.domain.library.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long>  {
}

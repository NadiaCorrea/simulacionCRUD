package com.jacaranda.primerSpring.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.primerSpring.model.Student;

@Service
public class StudentService {

	private List<Student> lista;

	public StudentService() {
		lista = new ArrayList<Student>();
		lista.add(new Student("Pepe", "Perez", 56));
		lista.add(new Student("Juan", "Prado", 25));
		lista.add(new Student("Maria", "Lopez", 23));
		lista.add(new Student("Paco", "Paez", 56));
	}

	public List<Student> getStudents() {
		return lista;
	}

	public Student getStudent(String name, String surname) {
		Student requiredStudent = null;
		boolean found = false;

		Iterator<Student> iterator = this.lista.iterator();

		while (iterator.hasNext() && !found) {
			Student iStudent = iterator.next();

			if (iStudent.getName().equals(name) && iStudent.getSurname().equals(surname)) {
				requiredStudent = iStudent;
				found = true;
			}
		}

		return requiredStudent;
	}

	public boolean addStudent(Student e) {
		return lista.add(e);
	}

	public boolean removeStudent(Student e) {
		return lista.remove(e);
	}

	public boolean updateStudent(Student e) {
		boolean encontrado = false;
		Student resultado = getStudent(e.getName(), e.getSurname());
		
		if(resultado != null) {
			encontrado = true;
			resultado.setAge(e.getAge());
		}

		return encontrado;
	}

}

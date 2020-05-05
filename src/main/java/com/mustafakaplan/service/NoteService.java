package com.mustafakaplan.service;

import java.util.ArrayList;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mustafakaplan.dao.NoteDAO;
import com.mustafakaplan.entity.Note;

@Service
@Transactional
public class NoteService 
{
	@Autowired
	private NoteDAO noteDao;
	
	public Long createNote(Note note, HttpServletRequest request)
	{
		note.setUser_id((long) 1);
		return noteDao.insert(note);
	}
	
	public Long updateNote(Note note, HttpServletRequest request)
	{
		noteDao.update(note);
		return 1l;
	}
	

	public Long deleteNote(Note note, HttpServletRequest request)
	{
		noteDao.delete(note);
		return 1l;
	}
	
	public ArrayList<Note> getAll()
	{
		return noteDao.getAll();
	}
	
	public ArrayList<Note> getAll(Long userId)
	{
		return noteDao.getAll(userId);
	}
	
	public Note getFindByNoteId(Long noteId)
	{
		return noteDao.getFindByNoteId(noteId);
	}
}

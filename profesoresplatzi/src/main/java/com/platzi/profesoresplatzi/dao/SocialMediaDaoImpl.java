package com.platzi.profesoresplatzi.dao;

import java.util.List;

import com.platzi.profesoresplatzi.model.Course;
import com.platzi.profesoresplatzi.model.SocialMedia;
import com.platzi.profesoresplatzi.model.TeacherSocialMedia;
import com.platzi.profesoresplatzi.model.Teacher;

public class SocialMediaDaoImpl extends AbstractSession implements SocialMediaDao {

	public void saveSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		getSession().persist(socialMedia);
		
	}

	public void deleteSocialMediaById(Long idSocialMedia) {
		// TODO Auto-generated method stub
		SocialMedia socialMedia = findSocialMediaById(idSocialMedia);
		if (socialMedia != null) {
			getSession().delete(socialMedia);
		}
		
	}

	public void updateSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		getSession().update(socialMedia);
		
	}

	public List<SocialMedia> findAllSocialMedias() {
		// TODO Auto-generated method stub
		return getSession().createQuery("From SocialMedia").list();
	}

	@Override
	public SocialMedia findSocialMediaById(Long idSocialMedia) {
		// TODO Auto-generated method stub
		return getSession().get(SocialMedia.class, idSocialMedia);
	}

	@Override
	public SocialMedia findByName(String name) {
		// TODO Auto-generated method stub
		return (SocialMedia) getSession().createQuery(
				"from SocialMedia where name = :name")
				.setParameter("name", name).uniqueResult();
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname) {
		// TODO Auto-generated method stub
		List<Object[]> objects = getSession().createQuery(
				"from TeacherSocialMedia tsm join tsm.socialMedia sm "
				+ "where = sm.idSocialMedia = :idSocialMedia and"
				+ " tsm.nickname = :nickname")
				.setParameter("idSocialMedia", idSocialMedia)
				.setParameter("nickname", nickname).list();
		if (objects.size() > 0) {
			for (Object[] arrayObject : objects) {
				for (Object objeto : objects) {
					if (objeto instanceof TeacherSocialMedia) {
							return (TeacherSocialMedia) objeto;
					}
				}
				
			}
		}
		return null;
	}
	
	
}

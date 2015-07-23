package com.ibrahimkuley.util.genericDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by hikuley on 25.05.2015.
 */
public abstract class GenericDaoImpl< T extends BaseEntity > implements GenericDao< T >
{

	@Autowired
	private SessionFactory sessionFactory;

	private Class< T > clazz;

	public GenericDaoImpl()
	{
		this.clazz = (Class< T >) GenericTypeResolver.resolveTypeArgument( getClass(), GenericDao.class );
	}

	public Class< T > getClazz()
	{
		return clazz;
	}

	public void setClazz( Class< T > clazz )
	{
		this.clazz = clazz;
	}

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory( SessionFactory sessionFactory )
	{
		this.sessionFactory = sessionFactory;
	}

	public Session getSession()
	{
		return this.getSessionFactory().getCurrentSession();
	}


	@Override
	@Transactional
	public T create( final T t )
	{
		this.getSession().save( t );
		return t;
	}

	@Override
	@Transactional
	public void delete( T t )
	{
		this.getSession().delete( t );
	}

	@Override
	@Transactional
	public T update( T t )
	{
		this.getSession().update( t );
		return t;
	}

	@Override
	@Transactional
	public T findById( Long id )
	{
		T t = (T) getSession().get( this.getClazz(), id );
		return t;
	}
}

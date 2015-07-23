package com.ibrahimkuley.util.genericDao;

/**
 * Created by hikuley on 25.05.2015.
 */
public interface GenericDao< T extends BaseEntity >
{

	T create( T t );

	void delete( T t );

	T update( T t );

	T findById( Long id );
}

package br.com.mph.dddutils.entities;

import br.com.mph.ddutils.identities.Identity;

public interface Entity<T extends Identity> {

	T getId();

}
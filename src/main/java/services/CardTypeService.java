package services;

import java.util.List;

import dao.CardTypeDao;
import entities.CardTypeEntity;

public class CardTypeService {

	private CardTypeDao cardTypeDao;

	public CardTypeService() {
		cardTypeDao = new CardTypeDao();
	}

	public List<CardTypeEntity> findAllTypes() {
		return cardTypeDao.findAllTypes();
	}

}

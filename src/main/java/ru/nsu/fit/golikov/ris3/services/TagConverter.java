package ru.nsu.fit.golikov.ris3.services;

import ru.nsu.fit.golikov.ris3.dtos.TagDTO;
import ru.nsu.fit.golikov.ris3.entities.Tag;

public class TagConverter {
    public static Tag dtoToEntity(TagDTO tagDTO) {
        Tag tag = new Tag();

        tag.setK(tagDTO.getK());
        tag.setV(tagDTO.getV());

        return tag;
    }

    public static TagDTO entityToDTO(Tag tag) {
        TagDTO tagDTO = new TagDTO();

        tagDTO.setId(tag.getId());
        tagDTO.setK(tag.getK());
        tagDTO.setV(tag.getV());

        return tagDTO;
    }
}

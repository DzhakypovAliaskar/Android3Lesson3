package com.example.android3lesson3.iu.characters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.android3lesson3.data.models.Character;
import com.example.android3lesson3.databinding.ItemCharacterBinding;
import java.util.ArrayList;
import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>{

    private List<Character> characters = new ArrayList<>();

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCharacterBinding binding = ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false);
        return new CharacterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.onBind(characters.get(position));
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder{
        private ItemCharacterBinding binding;
        public CharacterViewHolder(@NonNull ItemCharacterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Character character) {
            binding.tvName.setText(character.getName());
            binding.tvStatus.setText(character.getStatus());
            Glide.with(binding.getRoot())
                    .load(character.getImage())
                    .centerCrop()
                    .into(binding.ivCharacter);
        }
    }
}
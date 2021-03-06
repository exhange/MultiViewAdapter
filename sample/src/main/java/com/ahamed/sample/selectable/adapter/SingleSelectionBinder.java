/*
 * Copyright 2017 Riyaz Ahamed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ahamed.sample.selectable.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ahamed.multiviewadapter.BaseViewHolder;
import com.ahamed.multiviewadapter.ItemBinder;
import com.ahamed.multiviewadapter.util.ItemDecorator;
import com.ahamed.sample.R;
import com.ahamed.sample.common.model.SelectableItem;

public class SingleSelectionBinder
    extends ItemBinder<SelectableItem, SingleSelectionBinder.ViewHolder> {

  public SingleSelectionBinder(ItemDecorator itemDecorator) {
    super(itemDecorator);
  }

  @Override public ViewHolder create(LayoutInflater layoutInflater, ViewGroup parent) {
    return new ViewHolder(layoutInflater.inflate(R.layout.item_selectable, parent, false));
  }

  @Override public void bind(ViewHolder holder, SelectableItem item) {
    holder.tvTitle.setText(item.getContent());
    holder.ivIndicator.setImageResource(
        holder.isItemSelected() ? R.drawable.drawable_selection_indicator
            : R.drawable.drawable_circle);
  }

  @Override public boolean canBindData(Object item) {
    return item instanceof SelectableItem;
  }

  @Override public int getSpanSize(int maxSpanCount) {
    return maxSpanCount;
  }

  static class ViewHolder extends BaseViewHolder<SelectableItem> {

    private TextView tvTitle;
    private ImageView ivIndicator;

    ViewHolder(View itemView) {
      super(itemView);
      tvTitle = (TextView) itemView.findViewById(R.id.tv_content);
      ivIndicator = (ImageView) itemView.findViewById(R.id.iv_selection_indicator);

      setItemClickListener(new OnItemClickListener<SelectableItem>() {
        @Override public void onItemClick(View view, SelectableItem item) {
          toggleItemSelection();
        }
      });
    }
  }
}

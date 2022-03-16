---
# Feel free to add content and custom Front Matter to this file.
# To modify the layout, see https://jekyllrb.com/docs/themes/#overriding-theme-defaults

layout: default
permalink: /
---

<h2>top</h2>
<h2>{{ site.data.samplelist.docs_list_title }}</h2>
<ul>
   {% for item in site.data.samplelist.docs %}
      <li><a href="{{ item.url }}">{{ item.title }}</a></li>
   {% endfor %}
</ul>
<h2>bottom</h2>

# Access links below to navigate to different sections
- [Data structures work](https://rpeddakama.github.io/CSA-Data-Structures/datastructures.html)
- [Tech Talk Notes](https://rpeddakama.github.io/CSA-Data-Structures/TTnotes.html)
- [Test Prep](https://rpeddakama.github.io/CSA-Data-Structures/testprep.html)

---

- [Data structures work](/datastructures)
- [Tech Talk Notes](/ttnotes)
- [Test Prep](/testprep)
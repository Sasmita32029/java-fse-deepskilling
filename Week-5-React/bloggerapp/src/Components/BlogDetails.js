function BlogDetails() {
  const blogs = [
    {
      id: 1,
      title: "Introduction to React",
      author: "Admin"
    },
    {
      id: 2,
      title: "Understanding JSX",
      author: "Sasmita"
    },
    {
      id: 3,
      title: "React Hooks",
      author: "Developer"
    }
  ];

  return (
    <div>
      <h2>Blog Details</h2>

      <ul>
        {blogs.map((blog) => (
          <li key={blog.id}>
            <strong>{blog.title}</strong> - {blog.author}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BlogDetails;
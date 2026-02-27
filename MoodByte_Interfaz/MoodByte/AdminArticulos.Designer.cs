namespace MoodByte
{
    partial class AdminArticulos
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            components = new System.ComponentModel.Container();
            btnNuevoArticulo = new Button();
            btnEditarArticulo = new Button();
            btnBorrarArticulo = new Button();
            imageList1 = new ImageList(components);
            listViewArticulos = new ListView();
            pictureBoxArticulo = new PictureBox();
            panelTituloArticulo = new Panel();
            lblTitulo = new Label();
            navMenu = new Controles.Menu();
            ((System.ComponentModel.ISupportInitialize)pictureBoxArticulo).BeginInit();
            panelTituloArticulo.SuspendLayout();
            SuspendLayout();
            // 
            // btnNuevoArticulo
            // 
            btnNuevoArticulo.BackColor = Color.FromArgb(252, 144, 139);
            btnNuevoArticulo.FlatAppearance.BorderSize = 0;
            btnNuevoArticulo.FlatStyle = FlatStyle.Flat;
            btnNuevoArticulo.Font = new Font("Segoe UI", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnNuevoArticulo.ForeColor = SystemColors.ButtonHighlight;
            btnNuevoArticulo.Location = new Point(75, 497);
            btnNuevoArticulo.Margin = new Padding(3, 4, 3, 4);
            btnNuevoArticulo.Name = "btnNuevoArticulo";
            btnNuevoArticulo.Size = new Size(145, 31);
            btnNuevoArticulo.TabIndex = 1;
            btnNuevoArticulo.Text = "Nuevo";
            btnNuevoArticulo.UseVisualStyleBackColor = false;
            btnNuevoArticulo.Click += btnNuevoArticulo_Click;
            // 
            // btnEditarArticulo
            // 
            btnEditarArticulo.BackColor = Color.FromArgb(252, 144, 139);
            btnEditarArticulo.FlatAppearance.BorderSize = 0;
            btnEditarArticulo.FlatStyle = FlatStyle.Flat;
            btnEditarArticulo.Font = new Font("Segoe UI", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnEditarArticulo.ForeColor = SystemColors.ButtonHighlight;
            btnEditarArticulo.Location = new Point(488, 497);
            btnEditarArticulo.Margin = new Padding(3, 4, 3, 4);
            btnEditarArticulo.Name = "btnEditarArticulo";
            btnEditarArticulo.Size = new Size(145, 31);
            btnEditarArticulo.TabIndex = 2;
            btnEditarArticulo.Text = "Editar";
            btnEditarArticulo.UseVisualStyleBackColor = false;
            btnEditarArticulo.Click += btnEditarArticulo_Click;
            // 
            // btnBorrarArticulo
            // 
            btnBorrarArticulo.BackColor = Color.FromArgb(252, 144, 139);
            btnBorrarArticulo.FlatAppearance.BorderSize = 0;
            btnBorrarArticulo.FlatStyle = FlatStyle.Flat;
            btnBorrarArticulo.Font = new Font("Segoe UI", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnBorrarArticulo.ForeColor = SystemColors.ButtonHighlight;
            btnBorrarArticulo.Location = new Point(676, 497);
            btnBorrarArticulo.Margin = new Padding(3, 4, 3, 4);
            btnBorrarArticulo.Name = "btnBorrarArticulo";
            btnBorrarArticulo.Size = new Size(145, 31);
            btnBorrarArticulo.TabIndex = 3;
            btnBorrarArticulo.Text = "Borrar";
            btnBorrarArticulo.UseVisualStyleBackColor = false;
            btnBorrarArticulo.Click += btnBorrarArticulo_Click;
            // 
            // imageList1
            // 
            imageList1.ColorDepth = ColorDepth.Depth32Bit;
            imageList1.ImageSize = new Size(16, 16);
            imageList1.TransparentColor = Color.Transparent;
            // 
            // listViewArticulos
            // 
            listViewArticulos.BackColor = Color.White;
            listViewArticulos.BorderStyle = BorderStyle.None;
            listViewArticulos.Font = new Font("Segoe UI", 11F);
            listViewArticulos.FullRowSelect = true;
            listViewArticulos.Location = new Point(488, 77);
            listViewArticulos.Margin = new Padding(3, 4, 3, 4);
            listViewArticulos.Name = "listViewArticulos";
            listViewArticulos.Size = new Size(333, 387);
            listViewArticulos.TabIndex = 4;
            listViewArticulos.UseCompatibleStateImageBehavior = false;
            listViewArticulos.View = View.List;
            listViewArticulos.SelectedIndexChanged += listViewArticulos_SelectedIndexChanged;
            // 
            // pictureBoxArticulo
            // 
            pictureBoxArticulo.Location = new Point(75, 77);
            pictureBoxArticulo.Margin = new Padding(3, 4, 3, 4);
            pictureBoxArticulo.Name = "pictureBoxArticulo";
            pictureBoxArticulo.Size = new Size(285, 264);
            pictureBoxArticulo.TabIndex = 5;
            pictureBoxArticulo.TabStop = false;
            // 
            // panelTituloArticulo
            // 
            panelTituloArticulo.AutoScroll = true;
            panelTituloArticulo.Controls.Add(lblTitulo);
            panelTituloArticulo.Location = new Point(75, 349);
            panelTituloArticulo.Margin = new Padding(3, 4, 3, 4);
            panelTituloArticulo.Name = "panelTituloArticulo";
            panelTituloArticulo.Padding = new Padding(10);
            panelTituloArticulo.Size = new Size(285, 79);
            panelTituloArticulo.TabIndex = 6;
            // 
            // lblTitulo
            // 
            lblTitulo.AutoSize = true;
            lblTitulo.Dock = DockStyle.Top;
            lblTitulo.ForeColor = Color.FromArgb(245, 109, 95);
            lblTitulo.Location = new Point(10, 10);
            lblTitulo.MaximumSize = new Size(200, 0);
            lblTitulo.Name = "lblTitulo";
            lblTitulo.Size = new Size(0, 20);
            lblTitulo.TabIndex = 0;
            // 
            // navMenu
            // 
            navMenu.BackColor = Color.Transparent;
            navMenu.ForeColor = SystemColors.ControlText;
            navMenu.Location = new Point(-1, 2);
            navMenu.Margin = new Padding(3, 4, 3, 4);
            navMenu.Name = "navMenu";
            navMenu.Size = new Size(221, 38);
            navMenu.TabIndex = 7;
            // 
            // AdminArticulos
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.FromArgb(253, 238, 228);
            ClientSize = new Size(914, 600);
            Controls.Add(navMenu);
            Controls.Add(panelTituloArticulo);
            Controls.Add(pictureBoxArticulo);
            Controls.Add(listViewArticulos);
            Controls.Add(btnBorrarArticulo);
            Controls.Add(btnEditarArticulo);
            Controls.Add(btnNuevoArticulo);
            Margin = new Padding(3, 4, 3, 4);
            Name = "AdminArticulos";
            Text = "Administrar Artículos";
            Load += AdminArticulos_Load;
            ((System.ComponentModel.ISupportInitialize)pictureBoxArticulo).EndInit();
            panelTituloArticulo.ResumeLayout(false);
            panelTituloArticulo.PerformLayout();
            ResumeLayout(false);
        }

        #endregion
        private Button btnNuevoArticulo;
        private Button btnEditarArticulo;
        private Button btnBorrarArticulo;
        private ImageList imageList1;
        private ListView listViewArticulos;
        private PictureBox pictureBoxArticulo;
        private Panel panelTituloArticulo;
        private Label lblTitulo;
        private Controles.Menu navMenu;
    }
}